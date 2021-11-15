package com.kenshine.graphql.resolvers;

import com.kenshine.graphql.entity.User;
import com.kenshine.graphql.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private static final Logger logger = LogManager.getLogger(QueryResolver.class);

    @Resource
    private UserService userService;

    public User user(String nickname) {
        logger.info("Query Resolver ==> user");
        logger.info("params: nickname:{}", nickname);
        return userService.getUserByNickname(nickname);
    }

    public List<User> users() {
        logger.info("Query Resolver ==> users");
        return userService.listUsers();
    }
}
