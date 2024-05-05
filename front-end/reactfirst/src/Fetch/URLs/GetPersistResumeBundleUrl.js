import {testing} from "../../testingBool";

export function getPersistResumeBundleUrl() {
    return testing.testing
        ? "http://localhost:7777/simple-service-webapp/webapi/api/v1/resumeBundle/jest/persist"
        : "http://localhost:7777/simple-service-webapp/webapi/api/v1/resumeBundle/persist";
}