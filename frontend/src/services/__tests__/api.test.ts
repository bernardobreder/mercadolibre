import { describe, it, expect, beforeAll, afterEach, afterAll } from "vitest";
import { getProduto } from "../api";
import { http, HttpResponse } from "msw";
import { setupServer } from "msw/node";

// Mock do backend com erro para qualquer ID
const server = setupServer(
  http.get("http://localhost:8080/api/produtos/:id", () => {
    return new HttpResponse("Erro interno", { status: 500 });
  })
);

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe("getProduto", () => {
  it("deve lançar erro ao falhar a requisição", async () => {
    await expect(getProduto(123)).rejects.toThrow("Erro ao buscar produto");
  });
});
