package solar.mr.proc;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;


import com.spbsu.commons.func.types.ConversionRepository;
import com.spbsu.commons.func.types.SerializationRepository;

/**
 * User: solar
 * Date: 12.10.14
 * Time: 10:23
 */
public interface MRState extends Serializable {
  SerializationRepository<CharSequence> SERIALIZATION = new SerializationRepository<>(
      new SerializationRepository<>(ConversionRepository.ROOT, CharSequence.class),
      "solar.mr.io");

  @Nullable
  <T> T get(String uri);

  boolean availableAll(String[] consumes);
  boolean available(String consumes);
  String[] available();
}