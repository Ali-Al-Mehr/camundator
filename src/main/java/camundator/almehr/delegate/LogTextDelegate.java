package camundator.almehr.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("logTextDelegate")
public class LogTextDelegate implements JavaDelegate {

    private static final Logger logger =
            LoggerFactory.getLogger(LogTextDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {

        Object input = execution.getVariable("delegateInput");

        logger.info("Delegate input: {}", input);
    }
}