import {testing} from "../../testingBool";

export function getAllBundlesUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/jest/getAllBundles"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/getAllBundles";
}