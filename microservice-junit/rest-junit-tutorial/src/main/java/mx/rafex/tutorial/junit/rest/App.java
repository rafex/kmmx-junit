package mx.rafex.tutorial.junit.rest;

import java.util.EnumSet;
import java.util.logging.Logger;

import javax.servlet.DispatcherType;

import dev.rafex.ether.cli.CliDefault;
import dev.rafex.ether.cli.Values;
import dev.rafex.ether.rest.filters.CORSFilter;
import dev.rafex.ether.rest.servers.Server;
import mx.rafex.tutorial.junit.rest.servlet.person.PersonServlet;

public class App {

  private final static Logger LOGGER = Logger.getLogger(App.class.getName());
  
  public static void main(final String[] args) {
    
    final Values valuesCli = CliDefault.getInstance(args).parse();
    
    System.out.println(valuesCli.toString());
    
    final Server server = new Server.Builder().port(valuesCli.getPort()).host(valuesCli.getHost()).minThreads(valuesCli.getMinThreads()).maxThreads(valuesCli.getMaxThreads())
        .timeout(valuesCli.getIdleTimeout()).build();
    
    server.addServlet(PersonServlet.class);
    server.addFilter(CORSFilter.class, EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC));
    
    try {
      server.run();
    } catch (final Exception e) {
      LOGGER.warning(e.getMessage());
    } finally {
      server.stop();
      server.destroy();
    }
    
  }
}
