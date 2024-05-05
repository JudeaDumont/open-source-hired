import {testing} from "../../testingBool";

export function getMatchUrl() {
    return testing.testing
        ? 'http://localhost:7777/simple-service-webapp/webapi/api/v1/match'
        : 'http://localhost:7777/simple-service-webapp/webapi/api/v1/match';
}