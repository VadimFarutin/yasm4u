package com.expleague.lyadzhin.report.viewports;

import java.util.List;

/**
 * User: lyadzhin
 * Date: 10.04.15 16:43
 */
public class ViewportsModel {
  private final List<Viewport> viewports;

  public ViewportsModel(List<Viewport> viewports) {
    this.viewports = viewports;
  }

  public int count() {
    return viewports.size();
  }

  public Viewport at(int i) {
    return viewports.get(i);
  }

  @Override
  public String toString() {
    return "ViewportsModel{" +
            "viewports=" + viewports +
            '}';
  }
}
