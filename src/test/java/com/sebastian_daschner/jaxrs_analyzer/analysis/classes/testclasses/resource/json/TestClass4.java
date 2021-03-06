/*
 * Copyright (C) 2015 Sebastian Daschner, sebastian-daschner.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sebastian_daschner.jaxrs_analyzer.analysis.classes.testclasses.resource.json;

import com.sebastian_daschner.jaxrs_analyzer.model.elements.Element;
import com.sebastian_daschner.jaxrs_analyzer.model.elements.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import java.util.Collections;
import java.util.Set;

import static com.sebastian_daschner.jaxrs_analyzer.model.Types.*;

public class TestClass4 {

    @javax.ws.rs.GET
    public JsonObject method() {
        final JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.addNull("key");
        if ("".equals(""))
            objectBuilder.add("value", JsonValue.FALSE);
        objectBuilder.add("test", JsonValue.NULL);
        objectBuilder.add("test", JsonValue.TRUE);
        return objectBuilder.build();
    }

    public static Set<HttpResponse> getResult() {
        final com.sebastian_daschner.jaxrs_analyzer.model.elements.JsonObject jsonObject = new com.sebastian_daschner.jaxrs_analyzer.model.elements.JsonObject();
        jsonObject.getStructure().put("key", new Element(OBJECT, null));
        jsonObject.getStructure().put("value", new Element(JSON_VALUE, JsonValue.FALSE));
        jsonObject.getStructure().put("test", new Element(JSON_VALUE, JsonValue.NULL, JsonValue.TRUE));

        final HttpResponse httpResponse = new HttpResponse();
        httpResponse.getEntityTypes().add(JSON_OBJECT);
        httpResponse.getInlineEntities().add(jsonObject);

        return Collections.singleton(httpResponse);
    }

}
