package com.example;

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

        get("/values01", (req, res) -> {
            res.status(200);
            res.type("application/json");
            long seed = 1;
            Random generator = new Random(seed);
            List<Integer> values = new ArrayList<>(10);
            for (int ix = 0; ix < 10; ix++) {
                values.add(generator.nextInt(100));
            }
            return values;
        });
    }
}

