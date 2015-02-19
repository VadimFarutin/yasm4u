package solar.mr;

import solar.mr.routines.MRRecord;

/**
* User: solar
* Date: 19.02.15
* Time: 23:38
*/
public class DefaultMRErrorsHandler implements MRErrorsHandler {
  @Override
  public void error(String type, String cause, MRRecord record) {
    throw new RuntimeException("Error during record processing! type: " + type + ", cause: " + cause + ", record: [" + record.toString() + "]");
  }

  @Override
  public void error(Throwable th, MRRecord record) {
    if (th instanceof RuntimeException)
      throw (RuntimeException)th;
    throw new RuntimeException(th);
  }

  @Override
  public int errorsCount() {
    return 0;
  }
}
