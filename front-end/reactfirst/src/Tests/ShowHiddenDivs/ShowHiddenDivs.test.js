import {render, screen} from "@testing-library/react";
import App from "../../App";

describe('ShowHiddenDivs.test', () => {

    it('Available Resumes', () => {
        render(<App showHiddenDivsResume={true} searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        const linkElement = screen.getByText(/Available Resumes/i);
        expect(linkElement).toBeInTheDocument();
    })

    it('No Available Resumes', () => {
        render(<App showHiddenDivsResume={false} searchWordsAg={{"green": ["a"], "yellow": []}}/>);
        expect(()=>{screen.getByText(/Available Resumes/i)}).toThrow();
    })

    it('No Persist Resumes', () => {
        render(<App showHiddenDivs={false} searchWordsAg={{"green": ["a"], "yellow": []}}/>);
        expect(()=>{screen.getByText(/Persist Resume/i)}).toThrow();
    })
})
