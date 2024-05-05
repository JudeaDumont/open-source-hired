import {testing} from "../../testingBool";

export function getRemoveDescriptionUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/jest/removeDescription"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/keywordchecker/removeDescription";
}