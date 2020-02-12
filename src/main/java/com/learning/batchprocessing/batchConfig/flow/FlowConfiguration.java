package com.learning.batchprocessing.batchConfig.flow;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowConfiguration {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step_1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("Step 1 from inside flow foo");
					return RepeatStatus.FINISHED;
				}).build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step_2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("Step 2 from inside flow foo");
					return RepeatStatus.FINISHED;
				}).build();
	}

	@Bean
	public Flow foo() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flowFoo");

		flowBuilder.start(step1())
				.next(step2())
				.end();

		return flowBuilder.build();
	}

	@Bean
	public Flow bar() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flowBar");

		flowBuilder.start(step1())
				.next(step2())
				.end();

		return flowBuilder.build();
	}
}
