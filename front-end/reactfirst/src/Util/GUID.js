//so stupid I have to do this myself, crypto is not in jsdom, so here we are,
export function uuidv4() {
    return 'xxxxxxxx-xxxx-xxxx-yxxx-xxxxxxxxxxxx'
        .replace(/[xy]/g, function (c) {
            const r = Math.random() * 16 | 0,
                v = c === 'x' ? r : ((r & 0x3) | 0x8);
            return v.toString(16);
        });
}