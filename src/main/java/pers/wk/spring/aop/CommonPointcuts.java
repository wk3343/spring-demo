package pers.wk.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcuts {

    @Pointcut("execution(public * *(..))")
    public void allPublicMethods() {
    }

    @Pointcut("@annotation(pers.wk.spring.aop.Silently)")
    public void silentlyAnnotated() {
    }
}
