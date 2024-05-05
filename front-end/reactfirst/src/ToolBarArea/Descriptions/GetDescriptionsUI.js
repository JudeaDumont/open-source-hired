import {getDescriptions} from "./GetDescriptions";
import {createSelectableDescriptionSection} from "./CreateSelectableDescriptionSection";

export async function getDescriptionsUI() {
    return await getDescriptions().then((descriptions) => {
            let selectableDescriptions = []
            Object.keys(descriptions).forEach((key, index) => {
                selectableDescriptions.push(createSelectableDescriptionSection(key))
            });
            return selectableDescriptions
        }
    );
}