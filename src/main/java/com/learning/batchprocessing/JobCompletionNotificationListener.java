package com.learning.batchprocessing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.learning.batchprocessing.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
/**
 * Created by nichaurasia on Friday, January/24/2020 at 2:41 PM
 */

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.error(" BEFORE JOB Started !!!!");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED !! It's time to verify the results!!");

            List<User> results = jdbcTemplate.query(
                    "SELECT first_name, last_name FROM USERS", new RowMapper<User>() {

                        @Override
                        public User mapRow(ResultSet rs, int row) throws SQLException {
                            return new User(rs.getString(1), rs.getString(2));
                        }
                    });

            for (User person : results) {
                log.info("Found <" + person + "> in the database.");
            }
        }
    }
}