package edu.icet.crm.util.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//we can't use @RestController annotaion or @Service annotation here because there's no controller service behaviours here.
// So we use most common annotaion @Component here.
@Component
@Aspect
@Slf4j
public class LogOperationTimeAspect {

    //@Around--->If we use LogOperationTime annotation anywhere call this longExecutionTime method
    //also we have @Before and @After annotations instead of @Around annotation
    @Around("@annotation(edu.icet.crm.util.LogOperationTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //before execution
        long startTime = System.currentTimeMillis();

        //String name = joinPoint.getSignature().getName();
        //Object[] args = joinPoint.getArgs();

        Object proceed = joinPoint.proceed();

        //after execution
        long endTime = System.currentTimeMillis();
        //log.info("Method Name {}", name);
        //log.info("Recieved Arguments {}", args);

        log.info("Execution Time {}", endTime - startTime);
        return proceed;
    }
}
