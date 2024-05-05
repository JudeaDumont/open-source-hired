import descriptionsFetch from "../../Fetch/DescriptionsFetch/DescriptionsFetch";

export async function getDescriptions() {
    return await descriptionsFetch().then((descriptionMap) => {
            return descriptionMap
        }
    );
}