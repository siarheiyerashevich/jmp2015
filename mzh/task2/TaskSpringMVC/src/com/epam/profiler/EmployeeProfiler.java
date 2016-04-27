package com.epam.profiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class EmployeeProfiler {

	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(pjp.toShortString());
		boolean isException = false;
		try {
			return pjp.proceed();
		} catch (RuntimeException exception) {
			isException = true;
			throw exception;
		} finally {
			stopWatch.stop();
			TaskInfo taskInfo = stopWatch.getLastTaskInfo();
			System.out.println(taskInfo.getTaskName() + ": " + taskInfo.getTimeMillis() + " ms"
					+ (isException ? " (thrown Exception)" : ""));
		}
	}

}