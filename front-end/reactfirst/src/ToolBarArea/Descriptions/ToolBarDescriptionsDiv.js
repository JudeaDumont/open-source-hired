
import {useEffect, useState} from "react";
import {getDescriptionsUI} from "./GetDescriptionsUI";
import {PersistDescriptionsDiv} from "./PersistDescription/Components/PersistDescriptionsDiv";

export function ToolBarDescriptionsDiv() {
    const [descriptions, setDescriptions] = useState(<></>)
    window.refreshAvailableDescriptionsDiv = setDescriptions
    useEffect(() => {
        getDescriptionsUI().then((descriptions) => {
            setDescriptions(descriptions)
        })
    }, [descriptions]);
    return <div className={"toolbar-description-div toolbar-div"}>
        <h3>Available Descriptions</h3>
        {PersistDescriptionsDiv()}
        {descriptions}
    </div>;
}