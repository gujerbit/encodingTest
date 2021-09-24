export const getEncoding = {
    namespaced: true,
    state: () => ({
        none: '',
        encoding: '',
        base64: '',
    }),
    mutations: {
        setNone(state, value) {
            state.none = value;
        },
        setEncoding(state, value) {
            state.encoding = value;
        },
        setBase64(state, value) {
            state.base64 = value;
        }
    },
};