/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2015 Andreas Grimmer <a.grimmer@gmx.at>
 * Christoph Sperl <ch.sperl@gmx.at>
 * Stefan Wurzinger <swurzinger@gmx.at>
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
package org.apidesign.html.leaflet.api;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

/**
 *
 * @author Andreas Grimmer
 * 
 */
@JavaScriptResource("/org/apidesign/html/leaflet/api/leaflet-src.js")
public class Popup extends ILayer {
    
    static {
        registerLayerType("L.Popup", (obj)->new Popup(obj));
    }
    
    Popup(Object jsObj) {
        super(jsObj);
    }
    
    public Popup() {
        super(create(null, null));
    }
            
    public Popup(PopupOptions options) {
        super(create(options.getJSObj(), null));
    }
    
    public Popup(PopupOptions options, ILayer source) {
        super(create(options.getJSObj(), source.getJSObj()));
    }
    
    public Popup(ILayer source) {
        super(create(null, source.getJSObj()));
    }

    @JavaScriptBody(args = {"options", "source"}, body
            = "return L.popup(options, source);")
    private static native Object create(Object options, Object source);

    public Popup addTo(Map map) {
        addTo(jsObj, map.getJSObj());
        return this;
    }
    
    @JavaScriptBody(args = { "jsObj", "map" }, wait4js = false, body = 
        "jsObj.addTo(map);")
    private static native void addTo(Object jsObj, Object map);
    
    public Popup openOn(Map map) {
        openOn(jsObj, map.getJSObj());
        return this;
    }
    
    @JavaScriptBody(args = { "jsObj", "map" }, wait4js = false, body = 
        "jsObj.openOn(map);")
    private static native void openOn(Object jsObj, Object map);
    
    public Popup setLatLng(LatLng latLng) {
        setLatLng(jsObj, latLng.getJSObj());
        return this;
    }
    
    @JavaScriptBody(args = { "jsObj", "latlng" }, wait4js = false, body = 
        "jsObj.setLatLng(latlng);")
    private static native void setLatLng(Object jsObj, Object latlng);
    
    public LatLng getLatLng() {
        return new LatLng(getLatLng(jsObj));
    }
    
    @JavaScriptBody(args = { "jsObj" }, body = 
        "return jsObj.getLatLng();")
    private static native Object getLatLng(Object jsObj);
    
    public Popup setContent(String htmlContent) {
        setContent(jsObj, htmlContent);
        return this;
    }
    
    @JavaScriptBody(args = { "jsObj", "htmlContent" }, wait4js = false, body = 
        "jsObj.setContent(htmlContent);")
    private static native void setContent(Object jsObj, String htmlContent);
    
    public String getContent() {
        return getContent(jsObj);
    }
    
    @JavaScriptBody(args = { "jsObj" }, body = 
        "return jsObj.getContent();")
    private static native String getContent(Object jsObj);
    
    public Popup update() {
        update(jsObj);
        return this;
    }
    
    @JavaScriptBody(args = { "jsObj" }, wait4js = false, body = 
        "jsObj.update();")
    private static native void update(Object jsObj);
    
}