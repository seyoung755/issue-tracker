export interface LocalStorageDB {
  set: <T>(key: string, value: T) => void;
  get: (key: string) => string | void;
  reset: () => void;
}

export const localStorageDB: LocalStorageDB = {
  set: (key, value) => {
    if (typeof value !== 'string') {
      localStorage.setItem(key, JSON.stringify(value));
    } else {
      localStorage.setItem(key, value);
    }
  },
  get: key => {
    const item = localStorage.getItem(key);
    if (item !== null) {
      return JSON.parse(item);
    }
  },
  reset: () => {
    localStorage.clear();
  },
};
