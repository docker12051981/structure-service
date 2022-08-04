package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.Param;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GraphLookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description repository param recursive (ignored now but can used after)

 */

@Repository
public class ParamRepositoryImpl implements ParamGraphLookupRepository {

    private static final long MAX_DEPTH_SUPPORTED = 10000L;

    private final MongoTemplate mongoTemplate;

    public ParamRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<List<Param>> getSubTree(int treeId, int nodeId, Long maxDepth) {
        final Criteria byNodeId = new Criteria("nodeId").is(nodeId);
        final Criteria byTreeId = new Criteria("treeId").is(treeId);
        final MatchOperation matchStage = Aggregation.match(byTreeId.andOperator(byNodeId));

        GraphLookupOperation graphLookupOperation = GraphLookupOperation.builder()
                .from("param")
                .startWith("$nodeId")
                .connectFrom("nodeId")
                .connectTo("parentId")
                .restrict(new Criteria("treeId").is(treeId))
                .maxDepth(maxDepth != null ? maxDepth : MAX_DEPTH_SUPPORTED)
                .as("descendants");

        Aggregation aggregation = Aggregation.newAggregation(matchStage, graphLookupOperation);

        List<Param> results = mongoTemplate.aggregate(aggregation, "param", Param.class).getMappedResults();
        return CollectionUtils.isEmpty(results) ? Optional.empty() : Optional.of(results);
    }

}
