package com.learning.batchprocessing.batchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nitin on Sunday, February/09/2020 at 10:55 PM
 */
@Configuration
@EnableBatchProcessing
public class S2StepTransitionConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("#### STEP 1 ####");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    // Implemented using Lambda
    @Bean
    public Step step2(){
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("#### STEP 2 ####");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step step3(){
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("#### STEP 3 ####");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    //Build a job using the three steps
    @Bean
    public Job transitionJobUsingNext(){
        return jobBuilderFactory.get("transitionJobNext")
                .start(step1())
                .next(step3())
                .next(step2())
                .build();
    }
}
