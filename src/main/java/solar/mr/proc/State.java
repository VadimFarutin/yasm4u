package solar.mr.proc;

import com.spbsu.commons.func.Processor;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Set;


import com.spbsu.commons.func.types.ConversionRepository;
import com.spbsu.commons.func.types.SerializationRepository;

/**
 * User: solar
 * Date: 12.10.14
 * Time: 10:23
 */
public interface State extends Serializable {
  SerializationRepository<CharSequence> SERIALIZATION = new SerializationRepository<>(
      new SerializationRepository<>(ConversionRepository.ROOT, CharSequence.class),
      "solar.mr.io");

  @Nullable
  <T> T get(String uri);

  boolean available(String... consumes);
  Set<String> keys();
  <T> boolean processAs(String name, Processor<T> processor);
}