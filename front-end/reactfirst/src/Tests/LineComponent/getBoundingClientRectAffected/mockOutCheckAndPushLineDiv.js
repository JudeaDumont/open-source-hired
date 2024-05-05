export function mockOutCheckAndPushLineDiv() {
    window.checkAndPushLineDivsG = jest.fn((elementContainer, id, x0, y0, x1, y1) => {
        expect(elementContainer).toEqual([])
        expect(id).toContain("line-")
        expect(x0).toEqual(0)
        expect(y0).toEqual(0)
        expect(x1).toEqual(0)
        expect(y1).toEqual(0)
    })
}