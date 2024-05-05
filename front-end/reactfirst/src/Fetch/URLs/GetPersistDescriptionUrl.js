import {testing} from "../../testingBool";

export function getPersistDescriptionUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/description/jest/persist"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/description/persist";
}