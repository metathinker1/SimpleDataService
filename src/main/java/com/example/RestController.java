package com.example;

import static spark.Spark.*;

/**
 * Created by robertwood on 6/24/17.
 */
public class RestController {

    public RestController() {
        port(8033);

        get("/", (req, res) -> "SimpleDataService");
    }
}

