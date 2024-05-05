import {processResumesIntoMap} from "../../ToolBarArea/Resumes/ProcessResumesIntoMap";

describe('stripTags', () => {

    it('processResumesIntoMap', () => {
        let result = processResumesIntoMap(
            [
                "{\"id\":330,\"name\":\"testProcessResumesIntoMap\",\"plainTextToMatch\":\"test persist plaintext\",\"pdfGuid\":\"f9f3bda0-e7fc-4763-98e0-879322312607\",\"wordGuid\":\"f9f3bda0-e7fc-4763-98e0-879322312607\",\"plainTextGuid\":\"f9f3bda0-e7fc-4763-98e0-879322312607\",\"jobDescriptionGuid\":\"f9f3bda0-e7fc-4763-98e0-879322312607\"}"
            ]);
        expect(result).toEqual({
            "testProcessResumesIntoMap": "test persist plaintext"
        });
    })
})
