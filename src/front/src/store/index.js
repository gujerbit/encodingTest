import { createStore } from 'vuex';
import { getEncoding } from './modules/getEncoding';
import { postEncoding } from './modules/postEncoding';
import createPersistedState from 'vuex-persistedstate';

export default createStore({
    modules: {
        getEncoding,
        postEncoding
    },
    plugins: [
        createPersistedState()
    ]
});