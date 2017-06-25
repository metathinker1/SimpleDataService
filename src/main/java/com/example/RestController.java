package com.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static spark.Spark.*;

/**
 * Created by robertwood on 6/24/17.
 */
public class RestController {

    public RestController() {
        port(8033);

        get("/", (req, res) -> "SimpleDataService");

        // {DataLink:URL:https://stackoverflow.com/questions/29127490/how-to-get-the-request-parameters-using-get-in-spark-java-framework}
        get("/values01", (req, res) -> {
            res.status(200);
            res.type("application/json");
            Object check1 = req.queryParams();
            Object check2 = req.queryParams("numValues");
            int numValues = Integer.parseInt(req.queryParams("numValues"));
            //int numValues = 10;
            long seed = 1;
            Random generator = new Random(seed);
            List<Integer> values = new ArrayList<>(numValues);
            for (int ix = 0; ix < numValues; ix++) {
                values.add(generator.nextInt(100));
            }
            return new Gson().toJson(values);
        });
    }
}

