export function processDescriptionsIntoMap(jsonArrayWithDescriptions) {
    let mapNameDescription = {}
    jsonArrayWithDescriptions.forEach((r)=>{
        let descriptionObject = JSON.parse(r)
        mapNameDescription[descriptionObject.name] = descriptionObject.content
    });
    return mapNameDescription
}