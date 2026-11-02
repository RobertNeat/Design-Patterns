---
title: Strona główna
---

<div class="p-4 mb-4 rounded" style="background-color: var(--dp-dark); color: #fff;">
  <h1>Design Patterns</h1>
  <p class="mb-0">
    Wiki projektu prezentującego klasyczne wzorce projektowe GoF na przykładzie restauracji.
    Wybierz kategorię poniżej lub użyj menu po lewej stronie, aby przejść do konkretnego wzorca.
  </p>
</div>

<div class="accordion" id="home-accordion">
{% for category in site.data.patterns %}
  <div class="card category-card mb-3">
    <div class="card-header" id="heading-{{ category.key }}" data-bs-toggle="collapse" data-bs-target="#body-{{ category.key }}" aria-expanded="true" aria-controls="body-{{ category.key }}">
      <h2 class="h5 mb-0">{{ category.name }}</h2>
    </div>
    <div id="body-{{ category.key }}" class="collapse show" aria-labelledby="heading-{{ category.key }}">
      <ul class="list-group list-group-flush">
        {% for p in category.patterns %}
        <li class="list-group-item">
          <a href="{{ '/' | append: category.key | append: '/' | append: p.slug | append: '/' | relative_url }}">
            <strong>{{ p.name }}</strong>
          </a>
          <div class="text-muted small">{{ p.use }}</div>
        </li>
        {% endfor %}
      </ul>
    </div>
  </div>
{% endfor %}
</div>
