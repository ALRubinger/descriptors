package org.jboss.shrinkwrap.descriptor.spi.node;

import java.io.OutputStream;

import org.jboss.shrinkwrap.descriptor.api.DescriptorExportException;

/**
 * {@link NodeExporter} contract capable of exporting a 
 * {@link Node} type
 * 
 * @author <a href="mailto:ralf.battenfeld@bluewin.ch">Ralf Battenfeld</a>
 */
public interface NodeExporter {


	/**
	 * Exports the specified {@link Node} to the specified
	 * {@link OutputStream}.
	 * 
	 * @param node
	 * @param out
	 * @throws DescriptorExportException If an error occurred during export
	 * @throws IllegalArgumentException If either argument is not specified
	 */
	public void to(Node node, OutputStream out) throws DescriptorExportException, IllegalArgumentException;
}
