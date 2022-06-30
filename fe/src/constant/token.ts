export const ACCESS_TOKEN = 'accessToken' as const;
export const REFRESH_TOKEN = 'refreshToken' as const;

export type TokenTypes = typeof ACCESS_TOKEN | typeof REFRESH_TOKEN;
