import {testing} from "../../testingBool";

export function getAllDescriptionsUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/jest/getAllDescriptions"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/getAllDescriptions";
}