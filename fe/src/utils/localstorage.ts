export interface LocalStorageDB {
  set: <T>(key: string, value: T) => void;
  get: (key: string) => string | void;
  reset: () => void;
}

export const localStorageDB: LocalStorageDB = {
  set: (key, value) => {
    localStorage.setItem(key, JSON.stringify(value));
  },
  get: key => {
    const item = localStorage.getItem(key);
    if (!!item) {
      return JSON.parse(item);
    }
  },
  reset: () => {
    localStorage.clear();
  },
};
