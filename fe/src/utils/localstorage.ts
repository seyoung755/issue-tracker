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
    try {
      return item && JSON.parse(item);
    } catch (error) {
      return null;
    }
  },
  reset: () => {
    localStorage.clear();
  },
};
