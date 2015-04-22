package ru.yandex.se.lyadzhin.report.viewports;

import com.spbsu.commons.func.Computable;
import com.spbsu.commons.util.CollectionTools;
import ru.yandex.se.lyadzhin.report.sources.SourceRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* User: lyadzhin
* Date: 11.04.15 0:08
*/
class MockViewportBuilder implements ViewportBuilder {
  private final String viewportId;
  private final List<String> sourceKeys;

  public MockViewportBuilder(String viewportId) {
    this.viewportId = viewportId;
    // random sources
    final ArrayList<String> sourceKeys = new ArrayList<>(SourceRequest.ALL_SOURCES);
    Collections.shuffle(sourceKeys);
    this.sourceKeys = sourceKeys.subList(0, sourceKeys.size() / 2);
  }

  @Override
  public String id() {
    return viewportId;
  }

  @Override
  public SourceRequest[] requests() {
    final List<SourceRequest> result = CollectionTools.map(new Computable<String, SourceRequest>() {
      @Override
      public SourceRequest compute(String argument) {
        return new SourceRequest(argument);
      }
    }, sourceKeys);
    return result.toArray(new SourceRequest[result.size()]);
  }

  @Override
  public Viewport build() {
    return new Viewport() {
      @Override
      public String id() {
        return viewportId;
      }

      @Override
      public String toString() {
        return "Viewport{" +
                "viewportId='" + viewportId + '\'' +
                '}';
      }
    };
  }

  @Override
  public String toString() {
    return "MyViewportBuilder{" +
            "viewportId='" + viewportId + '\'' +
            '}';
  }
}