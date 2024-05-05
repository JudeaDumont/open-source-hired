import {Line} from "react-lineto";
import React from "react";

export function createLineDiv(id, x0, y0, x1, y1) {
    let yFinale0 = y0 + 15 + window.scrollY;
    let yFinale1 = y1 + 15 + window.scrollY;
    return <Line
        key={
            id
            + "-x0=" + x0 + "-y0=" + yFinale0 + "-x1=" + x1 + "-y1=" + yFinale1 //this is used to make duplicate lines apparent
        }
        borderColor={"green"}
        x0={x0}
        y0={yFinale0}
        x1={x1}
        y1={yFinale1}
    />;
}