import { render, screen } from "@testing-library/react";
import App from "../App";
import { http, HttpResponse } from "msw";
import { setupServer } from "msw/node";

// Mock do backend
const server = setupServer(
  http.get("http://localhost:8080/api/products/1", () => {
    return HttpResponse.json({
      name: "Samsung Galaxy A55",
      price: 439,
      description: "O Samsung A55 é rápido, moderno e bonito.",
      specs: {
        screenSize: '6.6"',
        storage: "256 GB",
        mainCamera: "50 MP",
        frontCamera: "32 MP",
        nfc: true,
      },
    });
  })
);

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe("App", () => {
  it("deve renderizar o conteúdo após carregar dados do backend", async () => {
    render(<App />);

    expect(await screen.findByText("Samsung Galaxy A55")).toBeInTheDocument();
    expect(await screen.findByText("R$ 439")).toBeInTheDocument();
    expect(
      await screen.findByText("O Samsung A55 é rápido, moderno e bonito.")
    ).toBeInTheDocument();

    expect(
      await screen.findByText(
        (_, el) => el?.textContent?.replace(/\s+/g, " ").trim() === 'Tela: 6.6"'
      )
    ).toBeInTheDocument();

    expect(
      await screen.findByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() === "Memória: 256 GB"
      )
    ).toBeInTheDocument();

    expect(
      await screen.findByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() ===
          "Câmera Principal: 50 MP"
      )
    ).toBeInTheDocument();
  });
});
