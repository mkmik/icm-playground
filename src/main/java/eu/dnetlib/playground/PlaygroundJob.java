package eu.dnetlib.playground;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.Graph;
import com.googlecode.sarasvati.GraphProcess;
import com.googlecode.sarasvati.mem.MemGraphProcess;

import eu.dnetlib.enabling.tools.AbstractSchedulable;

public class PlaygroundJob extends AbstractSchedulable {
	private static final Log log = LogFactory.getLog(PlaygroundJob.class);

	private Graph graph;

	/**
	 * workflow engine.
	 */
	@Resource
	private Engine engine;

	@Override
	protected void doExecute() {
		log.info("Starting job");

		final GraphProcess process = new MemGraphProcess(graph);
		engine.startProcess(process);

		log.info("Job started");
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
