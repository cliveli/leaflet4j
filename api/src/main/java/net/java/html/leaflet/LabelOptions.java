/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2017 Clive Li clive.li@medialinksaustralia.com.au
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.java.html.leaflet;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

/**
 * Created by cliveli on 25/5/17.
 */
@JavaScriptResource("plugins/leaflet.label-src.js")
public class LabelOptions {


  private static boolean initialized;
  private final Options options;

  /**
   * Create Label options, it will initial JS if it was not initialized before
   */
  public LabelOptions() {
    initJS();
    options = new Options();
    options.setValue("direction", "top"); //default direction

  }

  static void initJS() {
    if (!initialized) {
      init0();
      initialized = true;
    }
  }

  @JavaScriptBody(args = {}, body = "", wait4js = false)
  private static void init0() {
  }

  Object getJSObj() {
    return options.createJSObj();
  }

  /**
   *
   * @param hidden hidden or not, default true
   * @return this
   */
  public LabelOptions setHidden(boolean hidden) {
    options.setValue("noHide", !hidden);
    return this;
  }

  /**
   *
   * @param className css className
   * @return this
   */
  public LabelOptions setClassName(String className) {
    options.setValue("className", className);
    return this;
  }

  /**
   *
   * @param direction top|right|left supported so far
   * @return this
   */
  public LabelOptions setDirection(String direction) {
    options.setValue("direction", direction);
    return this;
  }


  /**
   *
   * @param offset offset for label position
   * @return this
   */
  public LabelOptions setOffset(Point offset) {
    options.setValue("offset", offset.getJSObj());
    return this;
  }

}
