import './App.css';
import EditableHighlighter from "./EditableHighlighter/EditableHighlighter";
import {
    checkAndPushLineDivs
} from "./EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CheckAndPushLineDivs";
import {useState} from "react";
import {ToolBarResumesButton} from "./ToolBarArea/Resumes/ToolBarResumesButton";
import {ToolBarResumesDiv} from "./ToolBarArea/Resumes/ToolBarResumesDiv";
import {ToolBarDescriptionsButton} from "./ToolBarArea/Descriptions/ToolBarDescriptionsButton";
import {ToolBarDescriptionsDiv} from "./ToolBarArea/Descriptions/ToolBarDescriptionsDiv";

function App(props) {
    const [showResumesUIBool, setShowResumesUIBool] = useState(props.showHiddenDivsResume);
    const [showDescriptionsBool, setShowDescriptionsBool] = useState(props.showHiddenDivsDescription);
    window.setShowResumesUIBool = setShowResumesUIBool;
    window.setShowDescriptionsBool = setShowDescriptionsBool;
    window.checkAndPushLineDivsG = checkAndPushLineDivs; //indirection availability for testing
    return (
        <div className="App" id={"parent"}>
            <header className="App-header">
                {ToolBarResumesButton(showResumesUIBool, setShowResumesUIBool)}
                {ToolBarDescriptionsButton(showDescriptionsBool, setShowDescriptionsBool)}
                <EditableHighlighter
                    searchWordsAg={props.searchWordsAg}
                >
                </EditableHighlighter>
                {showResumesUIBool && <ToolBarResumesDiv></ToolBarResumesDiv>}
                {showDescriptionsBool && <ToolBarDescriptionsDiv></ToolBarDescriptionsDiv>}
            </header>
        </div>
    );
}

export default App;
