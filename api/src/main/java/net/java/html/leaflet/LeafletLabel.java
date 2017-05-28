package net.java.html.leaflet;

import net.java.html.js.JavaScriptBody;

/**
 * Created by cliveli on 29/5/17.
 */
public class LeafletLabel extends ILayer{

  static {
    Options.initJS();
    registerLayerType("L.LeafletLabel", new Function<Object, ILayer>() {
      @Override
      public ILayer apply(Object obj) {
        return new LeafletLabel(obj);
      }
    });
  }

  LeafletLabel(Object jsObj) {
    super(jsObj);
  }



  public void toggleClassName(String className){
    toggleClassNameInternal(jsObj,className);
  }


  @JavaScriptBody(args = {"jsObj", "className"}, body
      = "jsObj.toggleClassName(className);")
  private static native void toggleClassNameInternal(Object jsObj, String className);


}
