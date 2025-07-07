import { render, screen } from "@testing-library/react";
import RelatedProducts from "../RelatedProducts";
import { describe, it, expect } from "vitest";

describe("RelatedProducts", () => {
  it("deve renderizar o título e a lista de produtos relacionados", () => {
    const produtos = [
      {
        id: 1,
        nome: "Produto Exemplo 1",
        preco: 399,
        imagem: "https://via.placeholder.com/150?text=Produto+1",
      },
      {
        id: 2,
        nome: "Produto Exemplo 2",
        preco: 399,
        imagem: "https://via.placeholder.com/150?text=Produto+2",
      },
      {
        id: 3,
        nome: "Produto Exemplo 3",
        preco: 399,
        imagem: "https://via.placeholder.com/150?text=Produto+3",
      },
    ];

    render(<RelatedProducts produtos={produtos} />);

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() ===
          "Produtos relacionados"
      )
    ).toBeInTheDocument();

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() === "Produto Exemplo 1"
      )
    ).toBeInTheDocument();
  });

  it("deve exibir mensagem quando não há produtos relacionados", () => {
    render(<RelatedProducts produtos={[]} />);

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() ===
          "Nenhum produto relacionado disponível."
      )
    ).toBeInTheDocument();
  });
});
