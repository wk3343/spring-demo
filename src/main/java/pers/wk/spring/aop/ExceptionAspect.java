package pers.wk.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Around("CommonPointcuts.allPublicMethods()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("signature name={}, args={}", pjp.getSignature().getName(), pjp.getArgs());
        Object retVal = pjp.proceed();
        logger.info("result={}", retVal);
        return retVal;
    }

    @Around("CommonPointcuts.silentlyAnnotated()")
    public Object catchException(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        try {
            retVal = pjp.proceed();
        } catch (Throwable throwable) {
            logger.error("error", throwable);
        }
        return retVal;
    }
}
