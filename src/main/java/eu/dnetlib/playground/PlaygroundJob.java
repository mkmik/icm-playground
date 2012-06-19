package eu.dnetlib.playground;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import eu.dnetlib.enabling.tools.AbstractSchedulable;

public class PlaygroundJob extends AbstractSchedulable {
	private static final Log log = LogFactory.getLog(PlaygroundJob.class);

	@Override
	protected void doExecute() {
		log.info("Started playing around");
	}
}
