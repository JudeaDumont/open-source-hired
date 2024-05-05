import {testing} from "../../testingBool";

export function getRemoveBundleUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/jest/removeBundle"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/removeBundle";
}